package com.bushemi.grpc;

import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {
    @Override
    public void login(User.LoginRequest request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("UserService.login");
        System.out.println("request = " + request);
        String username = request.getUsername();
        System.out.println("username = " + username);
        String password = request.getPassword();
        System.out.println("password = " + password);

        User.APIResponse.Builder builder = User.APIResponse.newBuilder();

        if (username.equals(password)) {
            builder.setResponseCode(200).setResponseMessage("success");
        } else {
            builder.setResponseCode(403).setResponseMessage("fail");
        }

        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(User.Empty request, StreamObserver<User.APIResponse> responseObserver) {
        System.out.println("UserService.logout");
        System.out.println("request = " + request);
    }
}
