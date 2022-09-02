from random import random


def creararchivo():
    archivo = open ("lab.txt","w")
    archivo.close()
    print("Hay un archivo.")

def escribir():
    archivo = open("lab.txt","a")
    i=0
    while(i<1000):
        cadena = random()
        cadenastring = str(cadena)
        i=i+1
        xd = str(i)
        archivo.write(xd+" "+cadenastring+"\n")
    archivo.close
    print("Se escribio algo")


creararchivo()
escribir()