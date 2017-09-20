Requisitos:
    Tener instalado maven3.
    Java 8.
Pasos para ejecutar:
    1 - En un terminal hacer un git clone https://github.com/marcecruz25/SegundoMutante.git

    2 - Estar dentro de la carpeta del proyecto raiz y ejecutar:
        mvn clean install

    3 - Correr la aplicacion
        mvn spring-boot:run

    4 - Probar el end-point creado haciendo un curl o por postman con el metodo POST.
        En postman por ejemplo se podra poner:
            http://localhost:8080/mutant
                Body: 
                    key: dna
                    value : "ATGCGA","CACTAC","TTTAGT","AGATGG","CCTCTA","TCACTT"

    5 - Como respuesta se obtiene un 200 si el dna del humano ingresado es un mutante, en caso contrario devuelve un 403.

    6 - Para habilitar el debug se debera descomentar la linea del pom.xml siguiente:

        <build>
		    <plugins>
			    <plugin>
				    <groupId>org.springframework.boot</groupId>
				    <artifactId>spring-boot-maven-plugin</artifactId>
				    <configuration>
					    <jvmArguments>
						    -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005
					    </jvmArguments>
				    </configuration>
			    </plugin>
		    </plugins>
	    </build>
        
