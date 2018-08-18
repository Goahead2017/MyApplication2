package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean;

import java.util.List;

/**
 * 接收军训小贴士的相关信息
 */

public class TipsDataBean {

    private String index;
    private List<DescribeBean> describe;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<DescribeBean> getDescribe() {
        return describe;
    }

    public void setDescribe(List<DescribeBean> describe) {
        this.describe = describe;
    }

    public static class DescribeBean {

        private String content;
        private int id;
        private String name;
        private String property;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }
    }
}
