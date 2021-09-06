package server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class grpcServer {
    public static void main(String[] arg) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9000).addService(new UserService()).build();
        server.start();
        System.out.println("server started!");
        server.awaitTermination();

    }
}
