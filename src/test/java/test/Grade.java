package test;

/**
 *
 * Created by tcf24 on 2016/5/4.
 */
enum Grade {
    A("100-90"){
        public String getLocalValue(){
            return "优";
        }
    }
    ,B("89-80"){
        public String getLocalValue(){
            return "良";
        }
    }
    ,C("79-70"){
        public String getLocalValue(){
            return "一般";
        }
    }
    ,D("69-60"){
        public String getLocalValue(){
            return "差";
        }
    }
    ,E("59-0"){
        public String getLocalValue(){
            return "不合格";
        }
    };

    Grade(String value){
        this.value = value;
    }

    String value;

    public String getValue() {
        return value;
    }

    String localValue;

    public abstract String getLocalValue();
}
