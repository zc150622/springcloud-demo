import com.anxin.springcloud.util.GsonUtil;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyTest {

    @Test
    public void myTest(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","zc");
        map.put("date",new Date());
        map.put("null",null);
        System.out.println(GsonUtil.gsonString(map));
    }
}
