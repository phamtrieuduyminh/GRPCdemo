package server;

import com.duyminh.grpc.APIReponse;
import com.duyminh.grpc.HelloServiceGrpc;
import com.duyminh.grpc.LoginRequest;
import io.grpc.stub.StreamObserver;

public class UserService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<APIReponse> reponseStreamObserver) {
        String mess = new String();
        boolean status = false;
        if (request.getUsername().equals("duyminh") && request.getPassword().equals("123")) {
            mess= request.getUsername();
            status = true;
        } else
            mess="login fail";


        APIReponse reponse = APIReponse.newBuilder().setResponsemessage(mess).setStatus(status).build();

        reponseStreamObserver.onNext(reponse);
        reponseStreamObserver.onCompleted();

    }
}
