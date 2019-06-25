package tests;

import org.junit.Test;
import static org.junit.Assert.*;


public class SymbolTableTest {
    @Test
    public void functionTest() {
        // without returns
        String fun1 = "Fun Name arg1 arg2 {Int x = 19;a[5] = 10;}";
        String fun2 = "Fun Name arg1 arg2 {\n" +
                "   x = 1;" +
                "   parallel {" +
                "       sequential {lock x;x = 4;unlock x;y = 2;z = 3;}\n" +
                "   }"+
                "}";
        String fun3 = "Fun Name arg1 arg2 {\n" +
                "in = 4;\n" +
                "}";
        // with returns
        String fun4 = ("Fun Int Name arg1 arg2 {Int x = 19;a[5] = 10;}");
        String fun5 = ("Fun Bool Name arg1 arg2 {\n" +
                "   x = 1;" +
                "   parallel {" +
                "       sequential {lock x;x = 4;unlock x;y = 2;z = 3;}\n" +
                "   }" +
                "   return x"+
                "}");
        String fun6 = ("Fun Arr Int Name arg1 arg2 {\n" +
                "in = 4;\n" +
                "return in\n" +
                "}");

    }

}
