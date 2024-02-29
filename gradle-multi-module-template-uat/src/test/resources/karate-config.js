function fn() {   
    /* get java system property 'karate.env' */
    var env = karate.env; 
    karate.log('karate.env system property was:', env);
    
    /* do not delete this - add variables here */
    var config = {
      
      someUrlBase: 'https://some-host.com/v1/auth/',
      anotherUrlBase: 'https://another-host.com/v1/'
    };

    /* connection timeouts to be use by tests */
    karate.configure('connectTimeout', 5000);
    karate.configure('readTimeout', 5000);
    return config;
  }