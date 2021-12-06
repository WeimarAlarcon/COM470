import math

class Sudoku():
    def __init__(self, orden):
        self.__orden = orden

    def getTotalCasillas(self):
        return int(math.pow(self.__orden, 4))

    def getCuadrado(self):
        return int(math.pow(self.__orden, 2))

    def convertirCadena(self,cadena):
        matriz = []
        for fila in range(9):
            matriz.append(list(cadena[fila * self.getCuadrado(): (fila + 1) * self.getCuadrado()]))
        return matriz
    #verifica si hay dobles numero en una lista
    def verficar(self,lista):
        return len(set(lista)) == self.getCuadrado()
    #extrae una caja del sokudo y la convertie en uns lista
    def extraerCaja(self,sudoku, numero):
        lista = []
        #   Calcular la fila y columna de la esquina
        #   superior izquierda de la caja.
        fila = self.__orden  * (numero // self.__orden )
        columna = self.__orden  * (numero % self.__orden )
        #   Extraer los 9 digitos de la caja y
        #   ponerlos en una lista.
        for row in range(fila, fila + self.__orden ):
            lista.extend(sudoku[row][columna:columna + self.__orden ])
        return lista

    def revisar(self,cadena):
        sudoku=self.convertirCadena(cadena)
        return self.revisarFilas(sudoku) and self.revisarColumnas(sudoku) and self.revisarCajas(sudoku)
        #   Revisar por filas.
    def revisarFilas(self,sudoku):
        for fila in sudoku:
            if not self.verficar(fila):
                return False
        #   Revisar por columnas
        return True
    def revisarColumnas(self,sudoku):
        for columna in range(self.getCuadrado()):
            col = []
            #   Reunir los digitos en la columna
            for fila in range(self.getCuadrado()):
                col.append(sudoku[fila][columna])
            #   Revisar los digitos.
            if not self.verficar(col):
                return False
        #   Revisar por cajas
        return True
    def revisarCajas(self,sudoku):
        for caja in range(self.getCuadrado()):
            #   Extraer los digitos de la caja
            box = self.extraerCaja(sudoku, caja)
            #   Revisar los digitos.
            if not self.verficar(box):
                return False
        return True
