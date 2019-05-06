package DesignPatterns.SimpleFactory;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    /**
     * 定义形状常亮类型
     * 系统需要扩展时直接在这添加定义即可
     * 进一步优化，可以可以直接用配置文件
     */
    public static final int SHAPE_TYPE_CIRCLE = 1;
    public static final int SHAPE_TYPE_LINE = 2;
    public static final int SHAPE_TYPE_RECTANGLE = 3;

    private static Map<Integer, String> shapes = new HashMap<Integer, String>();

    /**
     * 静态代码块，当java虚拟机加载ShapeFactory类的代码时，就会执行这段代码
     * 建立形状类型和形状类名的对应关系，需要指明包名
     */
    static {
        shapes.put(new Integer(SHAPE_TYPE_CIRCLE), "DesignPatterns.SimpleFactory.Circle");
        shapes.put(new Integer(SHAPE_TYPE_LINE), "DesignPatterns.SimpleFactory.Line");
        shapes.put(new Integer(SHAPE_TYPE_RECTANGLE), "DesignPatterns.SimpleFactory.Rectangle");
    }

    /**
     * 静态方法，构造具体的shape对象
     * @param type
     * @return
     */
    public static Shape getShape(int type){
        try {
            String className = shapes.get(new Integer(type));
            //运用Java反射机制构造形状对象
            return (Shape)Class.forName(className).newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
