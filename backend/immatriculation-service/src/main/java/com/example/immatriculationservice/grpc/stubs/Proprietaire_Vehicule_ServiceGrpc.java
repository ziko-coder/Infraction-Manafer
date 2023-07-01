package com.example.immatriculationservice.grpc.stubs;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 *service VehiculeService{
 *  rpc getVehiculeById( VehiculeId ) returns (Vehicule);
 *  rpc  getVehiculeList (GetVehiculeListRequest) returns (VehiculeListResponse);
 *}
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: gRPC.proto")
public final class Proprietaire_Vehicule_ServiceGrpc {

  private Proprietaire_Vehicule_ServiceGrpc() {}

  public static final String SERVICE_NAME = "Proprietaire_Vehicule_Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid,
      com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getGetProprietaireByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProprietaireById",
      requestType = com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid.class,
      responseType = com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid,
      com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getGetProprietaireByIdMethod() {
    io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid, com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getGetProprietaireByIdMethod;
    if ((getGetProprietaireByIdMethod = Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireByIdMethod) == null) {
      synchronized (Proprietaire_Vehicule_ServiceGrpc.class) {
        if ((getGetProprietaireByIdMethod = Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireByIdMethod) == null) {
          Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireByIdMethod = getGetProprietaireByIdMethod = 
              io.grpc.MethodDescriptor.<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid, com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proprietaire_Vehicule_Service", "getProprietaireById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire.getDefaultInstance()))
                  .setSchemaDescriptor(new Proprietaire_Vehicule_ServiceMethodDescriptorSupplier("getProprietaireById"))
                  .build();
          }
        }
     }
     return getGetProprietaireByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest,
      com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse> getGetProprietaireListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProprietaireList",
      requestType = com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest.class,
      responseType = com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest,
      com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse> getGetProprietaireListMethod() {
    io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest, com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse> getGetProprietaireListMethod;
    if ((getGetProprietaireListMethod = Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireListMethod) == null) {
      synchronized (Proprietaire_Vehicule_ServiceGrpc.class) {
        if ((getGetProprietaireListMethod = Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireListMethod) == null) {
          Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireListMethod = getGetProprietaireListMethod = 
              io.grpc.MethodDescriptor.<com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest, com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proprietaire_Vehicule_Service", "getProprietaireList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Proprietaire_Vehicule_ServiceMethodDescriptorSupplier("getProprietaireList"))
                  .build();
          }
        }
     }
     return getGetProprietaireListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid,
      com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getGetProprietaireByVehiculeIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetProprietaireByVehiculeId",
      requestType = com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid.class,
      responseType = com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid,
      com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getGetProprietaireByVehiculeIdMethod() {
    io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid, com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getGetProprietaireByVehiculeIdMethod;
    if ((getGetProprietaireByVehiculeIdMethod = Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireByVehiculeIdMethod) == null) {
      synchronized (Proprietaire_Vehicule_ServiceGrpc.class) {
        if ((getGetProprietaireByVehiculeIdMethod = Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireByVehiculeIdMethod) == null) {
          Proprietaire_Vehicule_ServiceGrpc.getGetProprietaireByVehiculeIdMethod = getGetProprietaireByVehiculeIdMethod = 
              io.grpc.MethodDescriptor.<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid, com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proprietaire_Vehicule_Service", "GetProprietaireByVehiculeId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire.getDefaultInstance()))
                  .setSchemaDescriptor(new Proprietaire_Vehicule_ServiceMethodDescriptorSupplier("GetProprietaireByVehiculeId"))
                  .build();
          }
        }
     }
     return getGetProprietaireByVehiculeIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId,
      com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule> getGetVehiculeByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVehiculeById",
      requestType = com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId.class,
      responseType = com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId,
      com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule> getGetVehiculeByIdMethod() {
    io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId, com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule> getGetVehiculeByIdMethod;
    if ((getGetVehiculeByIdMethod = Proprietaire_Vehicule_ServiceGrpc.getGetVehiculeByIdMethod) == null) {
      synchronized (Proprietaire_Vehicule_ServiceGrpc.class) {
        if ((getGetVehiculeByIdMethod = Proprietaire_Vehicule_ServiceGrpc.getGetVehiculeByIdMethod) == null) {
          Proprietaire_Vehicule_ServiceGrpc.getGetVehiculeByIdMethod = getGetVehiculeByIdMethod = 
              io.grpc.MethodDescriptor.<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId, com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proprietaire_Vehicule_Service", "getVehiculeById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule.getDefaultInstance()))
                  .setSchemaDescriptor(new Proprietaire_Vehicule_ServiceMethodDescriptorSupplier("getVehiculeById"))
                  .build();
          }
        }
     }
     return getGetVehiculeByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest,
      com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse> getGetVehiculeListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVehiculeList",
      requestType = com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest.class,
      responseType = com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest,
      com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse> getGetVehiculeListMethod() {
    io.grpc.MethodDescriptor<com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest, com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse> getGetVehiculeListMethod;
    if ((getGetVehiculeListMethod = Proprietaire_Vehicule_ServiceGrpc.getGetVehiculeListMethod) == null) {
      synchronized (Proprietaire_Vehicule_ServiceGrpc.class) {
        if ((getGetVehiculeListMethod = Proprietaire_Vehicule_ServiceGrpc.getGetVehiculeListMethod) == null) {
          Proprietaire_Vehicule_ServiceGrpc.getGetVehiculeListMethod = getGetVehiculeListMethod = 
              io.grpc.MethodDescriptor.<com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest, com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Proprietaire_Vehicule_Service", "getVehiculeList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new Proprietaire_Vehicule_ServiceMethodDescriptorSupplier("getVehiculeList"))
                  .build();
          }
        }
     }
     return getGetVehiculeListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static Proprietaire_Vehicule_ServiceStub newStub(io.grpc.Channel channel) {
    return new Proprietaire_Vehicule_ServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static Proprietaire_Vehicule_ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new Proprietaire_Vehicule_ServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static Proprietaire_Vehicule_ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new Proprietaire_Vehicule_ServiceFutureStub(channel);
  }

  /**
   * <pre>
   *service VehiculeService{
   *  rpc getVehiculeById( VehiculeId ) returns (Vehicule);
   *  rpc  getVehiculeList (GetVehiculeListRequest) returns (VehiculeListResponse);
   *}
   * </pre>
   */
  public static abstract class Proprietaire_Vehicule_ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getProprietaireById(com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProprietaireByIdMethod(), responseObserver);
    }

    /**
     */
    public void getProprietaireList(com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProprietaireListMethod(), responseObserver);
    }

    /**
     */
    public void getProprietaireByVehiculeId(com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> responseObserver) {
      asyncUnimplementedUnaryCall(getGetProprietaireByVehiculeIdMethod(), responseObserver);
    }

    /**
     */
    public void getVehiculeById(com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVehiculeByIdMethod(), responseObserver);
    }

    /**
     */
    public void getVehiculeList(com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVehiculeListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetProprietaireByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid,
                com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire>(
                  this, METHODID_GET_PROPRIETAIRE_BY_ID)))
          .addMethod(
            getGetProprietaireListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest,
                com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse>(
                  this, METHODID_GET_PROPRIETAIRE_LIST)))
          .addMethod(
            getGetProprietaireByVehiculeIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid,
                com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire>(
                  this, METHODID_GET_PROPRIETAIRE_BY_VEHICULE_ID)))
          .addMethod(
            getGetVehiculeByIdMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId,
                com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule>(
                  this, METHODID_GET_VEHICULE_BY_ID)))
          .addMethod(
            getGetVehiculeListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest,
                com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse>(
                  this, METHODID_GET_VEHICULE_LIST)))
          .build();
    }
  }

  /**
   * <pre>
   *service VehiculeService{
   *  rpc getVehiculeById( VehiculeId ) returns (Vehicule);
   *  rpc  getVehiculeList (GetVehiculeListRequest) returns (VehiculeListResponse);
   *}
   * </pre>
   */
  public static final class Proprietaire_Vehicule_ServiceStub extends io.grpc.stub.AbstractStub<Proprietaire_Vehicule_ServiceStub> {
    private Proprietaire_Vehicule_ServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Proprietaire_Vehicule_ServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Proprietaire_Vehicule_ServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Proprietaire_Vehicule_ServiceStub(channel, callOptions);
    }

    /**
     */
    public void getProprietaireById(com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProprietaireByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProprietaireList(com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProprietaireListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProprietaireByVehiculeId(com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetProprietaireByVehiculeIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVehiculeById(com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVehiculeByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVehiculeList(com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest request,
        io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVehiculeListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *service VehiculeService{
   *  rpc getVehiculeById( VehiculeId ) returns (Vehicule);
   *  rpc  getVehiculeList (GetVehiculeListRequest) returns (VehiculeListResponse);
   *}
   * </pre>
   */
  public static final class Proprietaire_Vehicule_ServiceBlockingStub extends io.grpc.stub.AbstractStub<Proprietaire_Vehicule_ServiceBlockingStub> {
    private Proprietaire_Vehicule_ServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Proprietaire_Vehicule_ServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Proprietaire_Vehicule_ServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Proprietaire_Vehicule_ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire getProprietaireById(com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request) {
      return blockingUnaryCall(
          getChannel(), getGetProprietaireByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse getProprietaireList(com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetProprietaireListMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire getProprietaireByVehiculeId(com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request) {
      return blockingUnaryCall(
          getChannel(), getGetProprietaireByVehiculeIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule getVehiculeById(com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId request) {
      return blockingUnaryCall(
          getChannel(), getGetVehiculeByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse getVehiculeList(com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetVehiculeListMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *service VehiculeService{
   *  rpc getVehiculeById( VehiculeId ) returns (Vehicule);
   *  rpc  getVehiculeList (GetVehiculeListRequest) returns (VehiculeListResponse);
   *}
   * </pre>
   */
  public static final class Proprietaire_Vehicule_ServiceFutureStub extends io.grpc.stub.AbstractStub<Proprietaire_Vehicule_ServiceFutureStub> {
    private Proprietaire_Vehicule_ServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private Proprietaire_Vehicule_ServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected Proprietaire_Vehicule_ServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new Proprietaire_Vehicule_ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getProprietaireById(
        com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProprietaireByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse> getProprietaireList(
        com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProprietaireListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire> getProprietaireByVehiculeId(
        com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid request) {
      return futureUnaryCall(
          getChannel().newCall(getGetProprietaireByVehiculeIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule> getVehiculeById(
        com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVehiculeByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse> getVehiculeList(
        com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVehiculeListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PROPRIETAIRE_BY_ID = 0;
  private static final int METHODID_GET_PROPRIETAIRE_LIST = 1;
  private static final int METHODID_GET_PROPRIETAIRE_BY_VEHICULE_ID = 2;
  private static final int METHODID_GET_VEHICULE_BY_ID = 3;
  private static final int METHODID_GET_VEHICULE_LIST = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final Proprietaire_Vehicule_ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(Proprietaire_Vehicule_ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PROPRIETAIRE_BY_ID:
          serviceImpl.getProprietaireById((com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid) request,
              (io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire>) responseObserver);
          break;
        case METHODID_GET_PROPRIETAIRE_LIST:
          serviceImpl.getProprietaireList((com.example.immatriculationservice.grpc.stubs.GRPC.GetProprietaireListRequest) request,
              (io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.ProprietaireListResponse>) responseObserver);
          break;
        case METHODID_GET_PROPRIETAIRE_BY_VEHICULE_ID:
          serviceImpl.getProprietaireByVehiculeId((com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaireid) request,
              (io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Proprietaire>) responseObserver);
          break;
        case METHODID_GET_VEHICULE_BY_ID:
          serviceImpl.getVehiculeById((com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeId) request,
              (io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.Vehicule>) responseObserver);
          break;
        case METHODID_GET_VEHICULE_LIST:
          serviceImpl.getVehiculeList((com.example.immatriculationservice.grpc.stubs.GRPC.GetVehiculeListRequest) request,
              (io.grpc.stub.StreamObserver<com.example.immatriculationservice.grpc.stubs.GRPC.VehiculeListResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class Proprietaire_Vehicule_ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    Proprietaire_Vehicule_ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.immatriculationservice.grpc.stubs.GRPC.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Proprietaire_Vehicule_Service");
    }
  }

  private static final class Proprietaire_Vehicule_ServiceFileDescriptorSupplier
      extends Proprietaire_Vehicule_ServiceBaseDescriptorSupplier {
    Proprietaire_Vehicule_ServiceFileDescriptorSupplier() {}
  }

  private static final class Proprietaire_Vehicule_ServiceMethodDescriptorSupplier
      extends Proprietaire_Vehicule_ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    Proprietaire_Vehicule_ServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (Proprietaire_Vehicule_ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new Proprietaire_Vehicule_ServiceFileDescriptorSupplier())
              .addMethod(getGetProprietaireByIdMethod())
              .addMethod(getGetProprietaireListMethod())
              .addMethod(getGetProprietaireByVehiculeIdMethod())
              .addMethod(getGetVehiculeByIdMethod())
              .addMethod(getGetVehiculeListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
