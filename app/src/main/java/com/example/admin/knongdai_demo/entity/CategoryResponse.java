package com.example.admin.knongdai_demo.entity;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {

    String code;
    boolean status;
    String msg;
    List<Category> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CategoryResponse{" +
                "code='" + code + '\'' +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    class Category{
        int id;
        boolean status;
        String cate_name;
        String des;
        @SerializedName("icon_name")
        String thumb;

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", status=" + status +
                    ", cate_name='" + cate_name + '\'' +
                    ", des='" + des + '\'' +
                    ", thumb='" + thumb + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

    }
}
