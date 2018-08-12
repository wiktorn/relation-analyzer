#!/bin/sh

cat >> /usr/local/tomcat/webapps/ROOT/WEB-INF/classes/config.properties << EOF
db.driverClassName=org.postgresql.Driver
db.url=jdbc:postgresql://${DB_HOST:-postgres}/${DB_NAME:-osm}
db.username=${DB_USER}
db.password=${DB_PASSWORD}
srtmDataDirectory=${SRTM_DIRECTORY}
EOF

if [ -n "$DB_URL" ] ; then
    CATALINA_OPTS="${CATALINA_OPTS} -Ddb.url=${DB_URL}"
fi

if [ -n "${DB_USER}" ] ; then
    CATALINA_OPTS="${CATALINA_OPTS} -Ddb.username=${DB_USER}"
fi

if [ -n "${DB_PASSWORD}" ] ; then
    CATALINA_OPTS="${CATALINA_OPTS} -Ddb.password=${DB_PASSWORD}"
fi

if [ -n "${SRTM_DIRECTORY}" ] ; then
    CATALINA_OPTS="${CATALINA_OPTS} -DsrtmDataDirectory=${SRTM_DIRECTORY}"
fi

export CATALINA_OPTS
exec catalina.sh run
