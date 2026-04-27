# Descripción del funcionamiento del programa

Este programa simula el funcionamiento de una tienda de videojuegos con diferentes módulos integrados. La idea principal es que el usuario pueda interactuar con varias funcionalidades dentro de un mismo sistema, como compras, colección de cartas, participación en eventos y visualización de reportes.

Al iniciar el programa, se muestra un menú principal desde donde se puede acceder a cada uno de los módulos disponibles.

## Tienda
En esta sección se maneja todo lo relacionado con la compra de videojuegos. El sistema carga un catálogo desde un archivo de texto, donde cada juego tiene información como código, nombre, género, precio, plataforma y stock.

El usuario puede:
- Ver el catálogo completo  
- Buscar juegos por código  
- Agregar juegos al carrito  
- Ver el total de la compra  
- Confirmar la compra  

Cuando se confirma una compra, el sistema descuenta el stock y guarda el registro en un historial.

## Álbum de cartas
Este módulo funciona como una colección de cartas tipo álbum. Internamente se maneja como una matriz, donde cada espacio puede contener una carta.

Cada carta tiene datos como:
- Código  
- Nombre  
- Tipo  
- Rareza  
- Ataque, defensa y vida  

El usuario puede agregar cartas al álbum, verlas organizadas en una cuadrícula e incluso intercambiarlas de posición. También se pueden guardar y cargar desde un archivo (`album.txt`), lo que permite mantener la información.

## Eventos (Torneos)
Aquí se manejan torneos o eventos. El sistema carga los torneos desde un archivo y el usuario puede inscribirse ingresando su nombre y el ID del torneo.

Las inscripciones se guardan en una cola, simulando el orden en el que las personas son atendidas. Luego, el sistema procesa la venta de tickets usando dos “taquillas”, atendiendo a los usuarios uno por uno y descontando la cantidad de boletos disponibles.

## Recompensas
El programa incluye un sistema de experiencia (XP). El usuario gana puntos al realizar acciones como:
- Comprar juegos  
- Participar en eventos  
- Agregar cartas al álbum  

Dependiendo de la cantidad de XP, el sistema asigna un nivel y un rango. También muestra logros alcanzados y un pequeño ranking (leaderboard).

## Reportes
El sistema puede generar reportes en formato HTML sobre diferentes áreas:
- Inventario de juegos  
- Ventas realizadas  
- Álbum de cartas  
- Torneos  

Estos reportes se crean automáticamente con fecha y hora en el nombre y se abren en el navegador.

## Datos del estudiante
Finalmente, hay un módulo donde se muestran los datos del estudiante cargados desde un archivo de texto, como nombre, carné, correo, sección y una pequeña descripción.

## En resumen
El programa integra varias estructuras y conceptos como listas enlazadas, matrices, colas, manejo de archivos y una interfaz gráfica. Todo esto se combina para simular un sistema completo con múltiples funcionalidades dentro de una tienda de videojuegos.
