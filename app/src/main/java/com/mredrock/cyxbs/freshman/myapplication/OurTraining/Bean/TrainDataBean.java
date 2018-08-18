package com.mredrock.cyxbs.freshman.myapplication.OurTraining.Bean;

import java.util.List;

/**
 * 接收军训风采相关的信息
 */

public class TrainDataBean {

    private List<VideoBean> video;
    private List<PictureBean> picture;

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public List<PictureBean> getPicture() {
        return picture;
    }

    public void setPicture(List<PictureBean> picture) {
        this.picture = picture;
    }

    public static class VideoBean {

        private String name;
        private String url;
        private VideoPicBean video_pic;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public VideoPicBean getVideo_pic() {
            return video_pic;
        }

        public void setVideo_pic(VideoPicBean video_pic) {
            this.video_pic = video_pic;
        }

        public static class VideoPicBean {

            private String name;
            private String url;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class PictureBean {

        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
