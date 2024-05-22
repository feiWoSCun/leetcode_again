package feiWoSCun.other.分布式.唯一id.雪花算法;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: feiWoSCun
 * @Time: 2023/12/10
 * @Email: 2825097536@qq.com
 */
public class SnowFlakeUtil {

    //初始时间戳
    private final static long START_TIMESTAMP = 1624796691000L;
    //数据中心占用的位数
    private final static long DATA_CENTER_BIT = 5;
    //机器标识占用的位数
    private final static long MACHINE_BIT = 5;
    //序列号占用的位数
    private final static long SEQUENCE_BIT = 12;


    /**
     * 每一部分的最大值
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);//1000
    private final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    private final static long MAX_DATA_CENTER_NUM = ~(-1L << DATA_CENTER_BIT);

    /**
     * 每一部分向左的位移
     */
    private final static long MACHINE_LEFT = SEQUENCE_BIT;
    private final static long DATA_CENTER_LEFT = SEQUENCE_BIT + MACHINE_BIT;
    private final static long TIMESTAMP_LEFT = DATA_CENTER_LEFT + DATA_CENTER_BIT;

    private final long idc;
    private final long serverId;
    private long sequence = 0L;
    private long lastTimeStamp = -1L;

    private long getNextMill() {
        long mill = System.currentTimeMillis();
        while (mill <= lastTimeStamp) {
            mill = System.currentTimeMillis();
        }
        return mill;
    }

    /**
     * 根据指定的数据中心ID和机器标志ID生成指定的序列号
     *
     * @param idc      数据中心ID
     * @param serverId 机器标志ID
     */
    public SnowFlakeUtil(long idc, long serverId) {
        if (idc > MAX_DATA_CENTER_NUM || idc < 0) {
            throw new IllegalArgumentException("IDC 数据中心编号非法！");
        }
        if (serverId > MAX_MACHINE_NUM || serverId < 0) {
            throw new IllegalArgumentException("serverId 机器编号非法！");
        }
        this.idc = idc;
        this.serverId = serverId;
    }

    /**
     * 生成下一个 ID
     *
     */
    public synchronized long genNextId() {
        long currTimeStamp = System.currentTimeMillis();
        if (currTimeStamp < lastTimeStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }
        if (currTimeStamp == lastTimeStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大
            if (sequence == 0L) {
                currTimeStamp = getNextMill();
            }
        } else {
            //不同毫秒内，序列号置为0
            sequence = 0L;
        }
        lastTimeStamp = currTimeStamp;
        return (currTimeStamp - START_TIMESTAMP) << TIMESTAMP_LEFT | idc << DATA_CENTER_LEFT | serverId << MACHINE_LEFT | sequence;
    }

    public static void main(String[] args) {
        SnowFlakeUtil snowFlake = new SnowFlakeUtil(4, 3);
        System.out.println(MAX_SEQUENCE);
        for (int i = 0; i < 100; i++) {
            if (i>90){
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(snowFlake.genNextId());
        }
    }
}