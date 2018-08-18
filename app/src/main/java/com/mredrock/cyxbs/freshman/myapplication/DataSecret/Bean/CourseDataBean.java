package com.mredrock.cyxbs.freshman.myapplication.DataSecret.Bean;

import java.util.List;

public class CourseDataBean {


    /**
     * array : [{"below_amount":101,"id":1,"subject_name":"大学物理A1"},{"below_amount":87,"id":2,"subject_name":"数据结构"},{"below_amount":84,"id":3,"subject_name":"高等数学A"}]
     * name : 通信与信息工程学院
     */

    private String name;
    private List<ArrayBean> array;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArrayBean> getArray() {
        return array;
    }

    public void setArray(List<ArrayBean> array) {
        this.array = array;
    }

    public static class ArrayBean {
        /**
         * below_amount : 101
         * id : 1
         * subject_name : 大学物理A1
         */

        private int below_amount;
        private int id;
        private String subject_name;

        public int getBelow_amount() {
            return below_amount;
        }

        public void setBelow_amount(int below_amount) {
            this.below_amount = below_amount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubject_name() {
            return subject_name;
        }

        public void setSubject_name(String subject_name) {
            this.subject_name = subject_name;
        }
    }
}
