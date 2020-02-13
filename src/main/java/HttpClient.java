import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.internal.StringUtil;

public class HttpClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new HttpClientChannelInitializer());
            String host = System.getenv("GLAHA_AGGREGATOR_HOST");
            String port = System.getenv("GLAHA_AGGREGATOR_PORT");
            host = StringUtil.isNullOrEmpty(host)?"localhost":host;
            port = StringUtil.isNullOrEmpty(port)?"8888":port;
            ChannelFuture channelFuture = bootstrap.connect(host,Integer.valueOf(port)).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            eventLoopGroup.shutdownGracefully();
        }
    }

}
