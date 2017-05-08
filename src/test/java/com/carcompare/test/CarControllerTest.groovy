package com.carcompare.test

import com.carcompare.controller.CarController
import com.carcompare.repository.CarRepository
import groovy.json.JsonSlurper
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.client.RestTemplate
import static org.springframework.http.HttpStatus.*
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import spock.lang.Specification


class CarControllerTest extends Specification{

    def url = 'http://localhost:8080'
    def controller = new CarController()
    def carRepository =  Mock(CarRepository)
    RestTemplate rt

    MockMvc mockMvc

    def 'setup'(){
        mockMvc = standaloneSetup(
                controller:controller,
                repository:carRepository
        ).build()
        rt = new RestTemplate()
    }

    def 'get car by id '(){

       when:
       def response = mockMvc.perform(get(url +'/car/1')).andReturn().response
       def content = new JsonSlurper().parseText(response.contentAsString)

       then:
       response.status == OK.value()
       response.contentType.contains('application/json')
       response.contentType == 'application/json;charset=UTF-8'
    }
}

