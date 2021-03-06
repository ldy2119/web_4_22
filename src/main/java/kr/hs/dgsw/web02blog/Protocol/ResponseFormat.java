package kr.hs.dgsw.web02blog.Protocol;

import lombok.Data;

@Data
public class ResponseFormat {
    private int code;
    private String desc;
    private Object data;

    public ResponseFormat(ResponseType rt, Object data, Object option)
    {
        this.code = rt.code();
        if(option instanceof Long || option instanceof String)
        {
            String.format(rt.desc(), option);
        }
        else
        {
            rt.desc();
        }
        this.data = data;
    }

    public ResponseFormat(ResponseType rt, Object data)
    {
        this(rt, data, null);
    }

    public ResponseFormat()
    {

    }
}
