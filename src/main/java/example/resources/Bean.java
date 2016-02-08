package example.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Bean { // just an element to wrap output

    public String value;

    public Bean() {
    }

    public Bean(String str) {
        value = str;
    }

}