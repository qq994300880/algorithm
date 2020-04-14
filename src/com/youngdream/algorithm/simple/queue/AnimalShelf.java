package com.youngdream.algorithm.simple.queue;

/**
 * @author YangDuan
 * @date 2020/4/14 22:07
 */
public class AnimalShelf {
    private AnimalNode temp;
    private AnimalNode anyOne;
    private AnimalNode anyNow;
    private AnimalNode dogOne;
    private AnimalNode dogNow;
    private AnimalNode catOne;
    private AnimalNode catNow;

    /**
     * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
     * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
     * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
     * <p>
     * 示例1:
     * 输入：
     * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
     * [[], [[0, 0]], [[1, 0]], [], [], []]
     * 输出：
     * [null,null,null,[0,0],[-1,-1],[1,0]]
     * <p>
     * 示例2:
     * 输入：
     * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
     * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
     * 输出：
     * [null,null,null,null,[2,1],[0,0],[1,0]]
     * 说明:
     * <p>
     * 收纳所的最大容量为20000
     */
    public AnimalShelf() {
        //  独家配方，静态内部类AnimalNode实现,双向链表加单链表形式实现
    }

    public void enqueue(int[] animal) {
        temp = new AnimalNode(animal[0], animal[1]);
        if (anyNow == null) {
            anyNow = temp;
            anyOne = temp;
        } else {
            temp.preAnyNode = anyNow;
            anyNow.nextAnyNode = temp;
            anyNow = anyNow.nextAnyNode;
        }
        // 猫
        if (animal[1] == 0) {
            if (catNow == null) {
                catNow = temp;
                catOne = temp;
            } else {
                catNow.nextCatNode = temp;
                catNow = catNow.nextCatNode;
            }
        } else {// 狗
            if (dogNow == null) {
                dogNow = temp;
                dogOne = temp;
            } else {
                dogNow.nextDogNode = temp;
                dogNow = dogNow.nextDogNode;
            }
        }
    }

    public int[] dequeueAny() {
        if (anyOne == null) {
            return new int[]{-1, -1};
        }
        temp = anyOne;
        // 任何
        if (anyHandler()) {
            return new int[]{temp.number, temp.kind};
        }
        // 猫
        if (temp.kind == 0) {
            catHandler();
        } else {// 狗
            dogHandler();
        }
        return new int[]{temp.number, temp.kind};
    }

    public int[] dequeueDog() {
        if (dogOne == null) {
            return new int[]{-1, -1};
        }
        temp = dogOne;
        //  处理Any节点
        if (anyNow == dogOne) {
            anyNow = dogOne.preAnyNode;
        }
        if (anyOne == dogOne) {
            if (anyHandler()) {
                return new int[]{temp.number, temp.kind};
            }
        } else {
            dogOne.preAnyNode.nextAnyNode = dogOne.nextAnyNode;
            if (dogOne.nextAnyNode != null) {
                dogOne.nextAnyNode.preAnyNode = dogOne.preAnyNode;
            }
        }
        // 处理Dog节点
        dogHandler();
        return new int[]{temp.number, temp.kind};
    }

    public int[] dequeueCat() {
        if (catOne == null) {
            return new int[]{-1, -1};
        }
        temp = catOne;
        //  处理Any节点
        if (anyNow == catOne) {
            anyNow = catOne.preAnyNode;
        }
        if (anyOne == catOne) {
            if (anyHandler()) {
                return new int[]{temp.number, temp.kind};
            }
        } else {
            catOne.preAnyNode.nextAnyNode = catOne.nextAnyNode;
            if (catOne.nextAnyNode != null) {
                catOne.nextAnyNode.preAnyNode = catOne.preAnyNode;
            }
        }
        // 处理Cat节点
        catHandler();
        return new int[]{temp.number, temp.kind};
    }

    private void dogHandler() {
        dogOne = dogOne.nextDogNode;
        if (dogOne == null) {
            dogNow = null;
        }
    }

    private void catHandler() {
        catOne = catOne.nextCatNode;
        if (catOne == null) {
            catNow = null;
        }
    }

    private boolean anyHandler() {
        anyOne = anyOne.nextAnyNode;
        if (anyOne == null) {
            anyNow = null;
            dogOne = null;
            dogNow = null;
            catOne = null;
            catNow = null;
            return true;
        }
        return false;
    }

    static class AnimalNode {
        AnimalNode preAnyNode;
        AnimalNode nextAnyNode;
        AnimalNode nextDogNode;
        AnimalNode nextCatNode;

        public AnimalNode(int number, int kind) {
            this.number = number;
            this.kind = kind;
        }

        int number;
        int kind;
    }
}
