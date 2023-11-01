package com.andyron.arblog;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArblogApplicationTests {

    @Test
    void contextLoads() {
        Parser parser = Parser.builder().build();
        String string = "### 全局搜索\n" +
                "\n" +
                "## 6、前端展示\n" +
                "\n" +
                "\n" +
                "\n" +
                "## 6.1 前端首页显示";
        Node document = parser.parse(string);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        System.out.println(renderer.render(document));
    }

}
