package com.example.trpg.Service;

import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Enumeration;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 雪花演算法
 *
 * @author penny
 * @since 2024/07/23
 */
@Slf4j
@Component
public class SnowflakeUtils {

    private static final int EPOCH_BITS = 41;

    private static final int NODE_ID_BITS = 10;

    private static final int SEQUENCE_BITS = 12;

    private static final long MAX_NODE_ID = (1L << NODE_ID_BITS) - 1;

    private static final long MAX_SEQUENCE = (1L << SEQUENCE_BITS) - 1;

    private static final long DEFAULT_CUSTOM_EPOCH = 1420070400000L;

    private final long nodeId;

    private final long customEpoch;

    private volatile long lastTimestamp = -1L;

    private volatile long sequence = 0L;

    public SnowflakeUtils(long nodeId, long customEpoch) {
        if (nodeId < 0 || nodeId > MAX_NODE_ID) {
            throw new IllegalArgumentException(String.format("NodeId must be between %d and %d", 0, MAX_NODE_ID));
        }
        this.nodeId = nodeId;
        this.customEpoch = customEpoch;
    }

    public SnowflakeUtils(long nodeId) {
        this(nodeId, DEFAULT_CUSTOM_EPOCH);
    }

    public SnowflakeUtils() {
        this.nodeId = createNodeId();
        this.customEpoch = DEFAULT_CUSTOM_EPOCH;
    }

    public synchronized long nextId() {
        long currentTimestamp = timestamp();

        if (currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & MAX_SEQUENCE;
            if (sequence == 0) {
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        return currentTimestamp << (NODE_ID_BITS + SEQUENCE_BITS)
                | (nodeId << SEQUENCE_BITS)
                | sequence;
    }


    private long timestamp() {
        return Instant.now().toEpochMilli() - customEpoch;
    }

    private long waitNextMillis(long currentTimestamp) {
        long timestamp = currentTimestamp;
        while (currentTimestamp == lastTimestamp) {
            timestamp = timestamp();
        }
        return timestamp;
    }

    private long createNodeId() {
        long id;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for (byte macPort : mac) {
                        sb.append(String.format("%02X", macPort));
                    }
                }
            }
            id = sb.toString().hashCode();
        } catch (Exception ex) {
            id = new SecureRandom().nextInt();
        }
        id = id & MAX_NODE_ID;
        return id;
    }

    public long[] parse(long id) {
        long maskNodeId = ((1L << NODE_ID_BITS) - 1) << SEQUENCE_BITS;
        long maskSequence = (1L << SEQUENCE_BITS) - 1;

        long timestamp = (id >> (NODE_ID_BITS + SEQUENCE_BITS)) + customEpoch;
        long nId = (id & maskNodeId) >> SEQUENCE_BITS;
        long seq = id & maskSequence;

        return new long[]{timestamp, nId, seq};
    }

    @Override
    public String toString() {
        return "SnowflakeUtils Settings [EPOCH_BITS=" + EPOCH_BITS + ", NODE_ID_BITS=" + NODE_ID_BITS
                + ", SEQUENCE_BITS=" + SEQUENCE_BITS + ", CUSTOM_EPOCH=" + customEpoch
                + ", NodeId=" + nodeId + "]";
    }

    /**
     * 使用範例
     */
    public static void main(String[] args) {
        SnowflakeUtils snowflakeUtilsUtils = new SnowflakeUtils();

        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                log.info("id => {}", snowflakeUtilsUtils.nextId());
            }
        });
        t.start();
    }
}
