package com.chapter_5.third.party.rest.API.clients.Impl;

import com.chapter_5.third.party.rest.API.Advices.ApiResponse;
import com.chapter_5.third.party.rest.API.Exceptions.ResourceNotFoundException;
import com.chapter_5.third.party.rest.API.clients.EmployeeClient;
import com.chapter_5.third.party.rest.API.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.Type;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    @Override
    public List<EmployeeDTO> getEmployees() {
        try{
            ApiResponse<List<EmployeeDTO>> employeeDTO = restClient
                    .get()
                    .uri("")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {});
            return employeeDTO.getData();
        } catch(Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        try {
            ApiResponse<EmployeeDTO> employeeDTOPost = restClient
                    .post()
                    .uri("")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Client side error");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOPost.getData();
        } catch (Exception e) {
            //this will occur when the other server is not running
            throw new RuntimeException(e);
        }

        /*also we can perform like this for getting header.body,status code
        public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
            try{
                ResponseEntity<ApiResponse<EmployeeDTO>> employeeDTOPost = restClient
                        .post()
                        .uri("")
                        .body(employeeDTO)
                        .retrieve()
                        .onStatus(HttpStatusCode::is4xxClientError, (req , res ) -> {
                            System.out.println(new String(res.getBody().readAllBytes()));
                            throw new ResourceNotFoundException("Client side error");
                        })
                        .toEntity(new ParameterizedTypeReference<>() {});
                employeeDTOPost.getHeader();
                employeeDTOPost.getStatusCode();
                return employeeDTOPost.getBody().getData();
            } catch(Exception e){
                throw new RuntimeException(e);
            }
            }
         */
    }


    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try{
            ApiResponse<EmployeeDTO> employeeDTO = restClient
                    .get()
                    .uri("{employeeId}" , employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req , res ) -> {
                        System.out.println(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Client side error");
                    })
                    .body(new ParameterizedTypeReference<>() {});
            return employeeDTO.getData();
        } catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
}
