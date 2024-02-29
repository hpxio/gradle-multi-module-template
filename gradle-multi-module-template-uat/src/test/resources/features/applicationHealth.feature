@healthcheck
Feature: Application Health Check
As a SDET I want to run application healthcheck 
Verify application is up & running in the given environment

Scenario: Application Health Check on Local Host
* karate.log('calling application healthcheck')
Given url 'http://localhost:8089/health'
When method GET
Then status 200
And match $ contains 'OK'