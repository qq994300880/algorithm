package com.youngdream.algorithm.array;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YoungDream
 * @Date 2019/10/14 17:22
 */
public class GetImportance {
    /**
     * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
     * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     * <p>
     * 示例 1:
     * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
     * 输出: 11
     * 解释:
     * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
     * <p>
     * 注意:
     * 一个员工最多有一个直系领导，但是可以有多个直系下属
     * 员工数量不超过2000。
     */
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        result = 0;
        //利用HashMap来保存员工信息，键为员工ID，值为员工信息
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        //调用计算方法
        get(id);
        return result;
    }

    //存储员工信息的HashMap
    private Map<Integer, Employee> map;

    //记录重要性
    private int result;

    //递归方法
    private void get(int id) {
        //获取对应员工信息
        Employee employee = map.get(id);
        //计算重要性值
        result += employee.importance;
        //对下属员工进行遍历递归
        for (Integer integer : employee.subordinates) {
            get(integer);
        }
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};