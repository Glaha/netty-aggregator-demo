import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.internal.StringUtil;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class HttpClientHandler extends ChannelInboundHandlerAdapter {

    private String message = "111111111111111111111111111111111" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd" +
            "=========================================================";

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        String host = System.getenv("GLAHA_AGGREGATOR_HOST");
        String port = System.getenv("GLAHA_AGGREGATOR_PORT");
        String path = System.getenv("GLAHA_AGGREGATOR_PATH");
        host = StringUtil.isNullOrEmpty(host)?"localhost":host;
        port = StringUtil.isNullOrEmpty(port)?"8888":port;
        path = StringUtil.isNullOrEmpty(path)?"/":path;
        DefaultFullHttpRequest httpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                HttpMethod.POST, "http://" + host + ":" + port + path);
        httpRequest.headers().set(HttpHeaderNames.HOST, host);
        httpRequest.headers().set(HttpHeaderNames.CONTENT_LENGTH, message.length());
        httpRequest.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.CLOSE);
        ByteBuf buffer = getContentByteBuf();
        httpRequest.content().writeBytes(buffer);
        ctx.channel().writeAndFlush(httpRequest).addListener(future -> {
            System.out.println("send request finished");
            ctx.close();
        });
    }

    private ByteBuf getContentByteBuf() {
        byte[] bytes = message.getBytes();
        int length = message.length();
        ByteBuf buffer = null;
        for (int i = 0; i < 2; i++) {
            buffer = Unpooled.buffer(length);
            buffer.writeBytes(bytes);
        }
        return buffer;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
