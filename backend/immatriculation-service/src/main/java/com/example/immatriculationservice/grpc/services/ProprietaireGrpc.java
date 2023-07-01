package com.example.immatriculationservice.grpc.services;

import com.example.immatriculationservice.entities.Proprietaire;
import com.example.immatriculationservice.entities.Vehicule;
import com.example.immatriculationservice.grpc.stubs.GRPC;
import com.example.immatriculationservice.grpc.stubs.Proprietaire_Vehicule_ServiceGrpc;
import com.example.immatriculationservice.repositories.ProprietaireRepository;
import com.example.immatriculationservice.repositories.VehiculeRepository;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//@GrpcService
@AllArgsConstructor
public class ProprietaireGrpc extends Proprietaire_Vehicule_ServiceGrpc.Proprietaire_Vehicule_ServiceImplBase {
    private final ProprietaireRepository proprietaireRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public void getProprietaireById(GRPC.Proprietaireid request, StreamObserver<GRPC.Proprietaire> responseObserver) {
        Long id=request.getId();
        Proprietaire proprietaire=proprietaireRepository.findById(id).orElseThrow(null);
        if (proprietaire!=null) {
            GRPC.Proprietaire proprietaireResponse = GRPC.Proprietaire.newBuilder()
                    .setId(Math.toIntExact(proprietaire.getId()))
                    .setNom(proprietaire.getName())
                    .setEmail(proprietaire.getEmail())
                    .build();
            responseObserver.onNext(proprietaireResponse);
        }
            responseObserver.onCompleted();


    }
    //


    @Override
    public void getProprietaireList(GRPC.GetProprietaireListRequest request, StreamObserver<GRPC.ProprietaireListResponse> responseObserver) {
        List<Proprietaire> proprietaires = proprietaireRepository.findAll();
        // Convert the list of proprietaires to a list of GRPC.Proprietaire messages
        List<GRPC.Proprietaire> grpcProprietaires = proprietaires.stream()
                .map(this::convertToGRPCProprietaire)
                .collect(Collectors.toList());

        // Create a ProprietaireListResponse with the list of GRPC.Proprietaire messages
        GRPC.ProprietaireListResponse response = GRPC.ProprietaireListResponse.newBuilder()
                .addAllProprietaire(grpcProprietaires)
                .build();

        responseObserver.onNext(response); // Send the response to the client
        responseObserver.onCompleted();
    }
    //
//    private GRPC.Proprietaire convertToGRPCProprietaire(Proprietaire proprietaire) {
//        // Convert your Proprietaire entity to a GRPC.Proprietaire message
//        return GRPC.Proprietaire.newBuilder()
//                .setId(Math.toIntExact(proprietaire.getId()))
//                .setNom(proprietaire.getName())
//                .setEmail(proprietaire.getEmail())
//                .setDatecreat(String.valueOf(proprietaire.getBirthDate()))
//                .build();
//    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void getVehiculeById(GRPC.VehiculeId request, StreamObserver<GRPC.Vehicule> responseObserver) {
        int vehiculeId = request.getId();
        Vehicule vehicule = vehiculeRepository.findById((long) vehiculeId).orElse(null);

        if (vehicule != null) {
            GRPC.Vehicule grpcVehicule = GRPC.Vehicule.newBuilder()
                    .setId(Math.toIntExact(vehicule.getId()))
                    .setMatricule(vehicule.getRegistrationNumber())
                    .setMarque(vehicule.getBrand())
                    .setPuissFiscal(vehicule.getFiscalPower())
                    .setModele(vehicule.getModel())
                    .setProprietaire(convertToGRPCProprietaire(vehicule.getProprietaire()))
                    .build();

            responseObserver.onNext(grpcVehicule);
        } else {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }

        responseObserver.onCompleted();
    }
    //return proprietaire of vehicule
    private GRPC.Proprietaire convertToGRPCProprietaire(Proprietaire proprietaire) {
        if (proprietaire == null) {
            // Handle the case when proprietaire is null (you can choose the appropriate behavior)
            return GRPC.Proprietaire.newBuilder().build(); // or throw an exception, return a default value, etc.
        }

        // Convert your Proprietaire entity to a GRPC.Proprietaire message
        return GRPC.Proprietaire.newBuilder()
                .setId(Math.toIntExact(proprietaire.getId()))
                .setNom(proprietaire.getName())
                .setBirthDate(String.valueOf(proprietaire.getBirthDate()))
                .setEmail(proprietaire.getEmail())
                .build();
    }

    @Override
    public void getVehiculeList(GRPC.GetVehiculeListRequest request, StreamObserver<GRPC.VehiculeListResponse> responseObserver) {
        List<Vehicule> vehicules = vehiculeRepository.findAll(); // Retrieve the list of vehicles from your data source

        // Convert the list of vehicles to GRPC Vehicule messages
        List<GRPC.Vehicule> grpcVehicules = new ArrayList<>();
        for (Vehicule vehicule : vehicules) {
            GRPC.Vehicule grpcVehicule = convertToGRPCVehicule(vehicule);
            grpcVehicules.add(grpcVehicule);
        }

        // Create the VehiculeListResponse and send it to the client
        GRPC.VehiculeListResponse response = GRPC.VehiculeListResponse.newBuilder()
                .addAllVehicule(grpcVehicules)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    //
    private GRPC.Vehicule convertToGRPCVehicule(Vehicule vehicule) {
        return GRPC.Vehicule.newBuilder()
                .setId(Math.toIntExact(vehicule.getId()))
                .setMarque(vehicule.getBrand())
                .setMatricule(vehicule.getRegistrationNumber())
                .setModele(vehicule.getModel())
                .setPuissFiscal(vehicule.getFiscalPower())
                .build();
    }

    @Override
    public void getProprietaireByVehiculeId(GRPC.Proprietaireid request, StreamObserver<GRPC.Proprietaire> responseObserver) {
        Long id = request.getId();
        Vehicule vehicule = vehiculeRepository.selectById(id);

        if (vehicule != null) {
            long proprietaireId = vehiculeRepository.selectProprietaireByIdVehicule(id);
            Proprietaire proprietaire = proprietaireRepository.findById(proprietaireId).orElse(null);

            if (proprietaire != null) {
                GRPC.Proprietaire grpcProprietaire = GRPC.Proprietaire.newBuilder()
                        .setId(Math.toIntExact(proprietaire.getId()))
                        .setNom(proprietaire.getName())
                        .setEmail(proprietaire.getEmail())
                        .build();

                responseObserver.onNext(grpcProprietaire);
            } else {
                responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
            }
        } else {
            responseObserver.onError(Status.NOT_FOUND.asRuntimeException());
        }

        responseObserver.onCompleted();
    }

}
