package com.carcompare.groovy

import com.carcompare.controller.CarController
import com.carcompare.repository.CarRepository
import groovy.json.JsonSlurper
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification

import static org.springframework.http.HttpStatus.OK
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class CarControllerSpec extends Specification{

    def  controller = new CarController()
    def  repository =  Mock(CarRepository)
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(CarController).build()

    def setup() {
        controller.carRepository  = repository
    }


    def 'get a single car'(){

        when:
        def response = mockMvc.perform(get('/car/{car_id}', 1)).andReturn().response

        then:
        //Testing the HTTP Status code
        response.status == OK.value()

        //Showing how a contains test could work
        response.contentType.contains('application/json')
        response.contentType == 'application/json;charset=UTF-8'

        //Can test the whole content string that is returned
        response.contentAsString == '{"id":1,"id_automaker":1,"model":"Optima","year":2015}'

        def content = new JsonSlurper().parseText(response.contentAsString)

        // JsonSlurper to assert JSON as object
        content.model == 'Optima'
    }

    def 'get list of brands'(){
        when:
        def response = mockMvc.perform(get('/autoMakers')).andReturn().response

        then:
        response.status == OK.value()
        response.contentType.contains('application/json')
        response.contentType == 'application/json;charset=UTF-8'
    }

}
