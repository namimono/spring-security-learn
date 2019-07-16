package com.namimono.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vtb  {
    private String id;
    private String name;
    private Integer age;
    private String company;
    private String channel;

//    public static class Builder{
//        private String id;
//        private String name;
//        private Integer age;
//        private String company;
//        private String channel;
//
//        public Builder(String name) {
//            this.name = name;
//        }
//
//        public Builder id(String id){
//            this.id=id;
//            return this;
//        }
//        public Builder name(String name){
//            this.name=name;
//            return this;
//        }
//        public Builder age(Integer age){
//            this.age=age;
//            return this;
//        }
//        public Builder company(String company){
//            this.company=company;
//            return this;
//        }
//        public Builder channel(String channel){
//            this.channel=channel;
//            return this;
//        }
//        public Vtb build(){
//            return new Vtb(this);
//        }
//
//    }
//    private Vtb(Builder builder){
//        this.id=builder.id;
//        this.name=builder.name;
//        this.age=builder.age;
//        this.company=builder.company;
//        this.channel=builder.channel;
//
//    }

    @Override
    public String toString() {
        return "Vtb{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", channel='" + channel + '\'' +
                '}';
    }
}
