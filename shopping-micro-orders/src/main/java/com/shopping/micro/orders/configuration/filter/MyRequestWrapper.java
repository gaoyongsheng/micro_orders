package com.shopping.micro.orders.configuration.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Slf4j
public class MyRequestWrapper extends HttpServletRequestWrapper {

    private final Map<String, String> jemcoHeader;
    private String body;

    /**
     * Instance JemcoHttpServletRequest.
     * @param request 请求的Request
     * @throws IOException the io exception
     */
    public MyRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        this.jemcoHeader = new HashMap<String, String>();
        StringBuffer sb = new StringBuffer();
        request.setCharacterEncoding("UTF-8");
        BufferedReader br = request.getReader();
        String readLine;
        while ((readLine = br.readLine()) != null) {
            sb.append(readLine);
        }
        this.body = sb.toString();
    }

    public void putHeader(String name, String value) {
        this.jemcoHeader.put(name, value);
    }

    /**
     * Get Header.
     */
    @Override
    public String getHeader(String name) {
        String headerValue = jemcoHeader.get(name);

        if (headerValue != null) {
            return headerValue;
        }
        return ((HttpServletRequest) getRequest()).getHeader(name);
    }

    /**
     * Get HeaderNames.
     */
    @Override
    public Enumeration<String> getHeaderNames() {
        Set<String> set = new HashSet<String>(jemcoHeader.keySet());

        Enumeration<String> enumeration = ((HttpServletRequest) getRequest()).getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String next = enumeration.nextElement();
            set.add(next);
        }

        return Collections.enumeration(set);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body.getBytes("UTF-8"));
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readlistener) {
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    public String getBody() {
        return body;
    }

}
