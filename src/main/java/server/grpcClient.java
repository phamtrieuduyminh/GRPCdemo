package server;

import com.duyminh.grpc.APIReponse;
import com.duyminh.grpc.HelloServiceGrpc;
import com.duyminh.grpc.LoginRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.util.Scanner;

public class grpcClient {
    public static void main(String[] arg) throws IOException, InterruptedException {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(managedChannel);
        Scanner scanner = new Scanner(System.in);
        System.out.print("UserName: ");
        String username = scanner.next();
        System.out.print("password: ");
        String password = scanner.next();
        APIReponse apiReponse = stub.login(LoginRequest.newBuilder().
                setUsername(username.trim()).setPassword(password.trim()).build());

        System.out.println("username " +apiReponse.getResponsemessage());
        System.out.println(apiReponse.getStatus() ?"login success":"login failure");


    }


}
