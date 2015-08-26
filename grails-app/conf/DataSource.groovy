dataSource {
    pooled = true
    driverClassName = "oracle.jdbc.OracleDriver"
    dialect = org.hibernate.dialect.Oracle10gDialect
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
//            dbCreate = "update"
//            url      = "jdbc:oracle:thin:@61.228.55.178:1521:xe"
            url      = "jdbc:oracle:thin:@104.155.211.29:1521:xe"
            username = "netwin"
            password = "Ppn1234.."
        }
    }
    test {
        dataSource {
//            dbCreate = "update"
//            url      = "jdbc:oracle:thin:@61.228.55.178:1521:xe"
            url      = "jdbc:oracle:thin:@127.0.0.1:xe"
            username = "netwin"
            password = "Ppn1234.."

            properties {
                // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
                jmxEnabled = true
                initialSize = 5
                maxActive = 150
                minIdle = 5
                maxIdle = 25
                maxWait = 10000
                maxAge = 10 * 60000
                timeBetweenEvictionRunsMillis = 5000
                minEvictableIdleTimeMillis = 60000
                validationQuery = "SELECT 1 FROM DUAL"
                validationQueryTimeout = 3
                validationInterval = 15000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = "ConnectionState"
                //defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED


            }
        }
    }
    production {
        dataSource {
//            dbCreate = "update"
//            url      = "jdbc:oracle:thin:@61.228.55.178:1521:xe"
            url      = "jdbc:oracle:thin:@127.0.0.1:xe"
            username = "netwin"
            password = "Ppn1234.."
            properties {
               // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
               jmxEnabled = true
               initialSize = 5
               maxActive = 50
               minIdle = 5
               maxIdle = 25
               maxWait = 10000
               maxAge = 10 * 60000
               timeBetweenEvictionRunsMillis = 5000
               minEvictableIdleTimeMillis = 60000
               validationQuery = "SELECT 1"
               validationQueryTimeout = 3
               validationInterval = 15000
               testOnBorrow = true
               testWhileIdle = true
               testOnReturn = false
               jdbcInterceptors = "ConnectionState"
               defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
