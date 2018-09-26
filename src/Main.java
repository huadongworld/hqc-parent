import com.ys.hdc.proxy.socket.ActionSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HD
 * @date 2018/7/10 21:43
 */
public class Main {

    public static void main(String[] args) throws IOException {

        ServerSocket server  = new ServerSocket(8888);
        while(true){
            Socket socket = server.accept();
            ActionSocket ap = new ActionSocket(socket);
            ap.start();
        }
    }
}
