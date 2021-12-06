import unittest
from sudoku import Sudoku


class claseTest(unittest.TestCase):

    def setUp(self):
        self.ordenUno  = Sudoku(1)
        self.ordenDos  = Sudoku(2)
        self.ordenTres = Sudoku(3)

    def tearDonw(self):
        pass

    def testOrdenUno(self):
        self.assertEqual(1, self.ordenUno.getTotalCasillas())

    def testOrdenDos(self):
        self.assertEqual(16, self.ordenDos.getTotalCasillas())

    def testOrdenTres(self):
        self.assertLessEqual(81, self.ordenTres.getTotalCasillas())



    def testCuadradoUno(self):
        self.assertLessEqual(1, self.ordenUno.getCuadrado())

    def testCuadradoDos(self):
        self.assertLessEqual(4, self.ordenDos.getTotalCasillas())

    def testCuadradoTres(self):
        self.assertLessEqual(9, self.ordenTres.getTotalCasillas())
    def testeVerificarDoblesNumerosLista(self):
        lista=['4', '3', '5', '2', '6', '9', '7', '8', '1']
        
        self.assertTrue(self.ordenTres.verficar(lista))

    def testConvertirCadena(self):
        esperado=[
            ['4', '3', '5', '2', '6', '9', '7', '8', '1'], 
            ['6', '8', '2', '5', '7', '1', '4', '9', '3'],
            ['1', '9', '7', '8', '3', '4', '5', '6', '2'], 
            ['8', '2', '6', '1', '9', '5', '3', '4', '7'], 
            ['3', '7', '4', '6', '8', '2', '9', '1', '5'], 
            ['9', '5', '1', '7', '4', '3', '6', '2', '8'], 
            ['5', '1', '9', '3', '2', '6', '8', '7', '4'], 
            ['2', '4', '8', '9', '5', '7', '1', '3', '6'], 
            ['7', '6', '3', '4', '1', '8', '2', '5', '9']
        ]
        cadena="435269781682571493197834562826195347374682915951743628519326874248957136763418259"
        self.assertLessEqual(esperado, self.ordenTres.convertirCadena(cadena))


    def testValirdarFila(self):
        sudoku=[
            ['4', '3', '5', '2', '6', '9', '7', '8', '1'], 
            ['6', '8', '2', '5', '7', '1', '4', '9', '3'],
            ['1', '9', '7', '8', '3', '4', '5', '6', '2'], 
            ['8', '2', '6', '1', '9', '5', '3', '4', '7'], 
            ['3', '7', '4', '6', '8', '2', '9', '1', '5'], 
            ['9', '5', '1', '7', '4', '3', '6', '2', '8'], 
            ['5', '1', '9', '3', '2', '6', '8', '7', '4'], 
            ['2', '4', '8', '9', '5', '7', '1', '3', '6'], 
            ['7', '6', '3', '4', '1', '8', '2', '5', '9']
        ]
        self.assertTrue(self.ordenTres.revisarFilas(sudoku))


    def testRevisarColumnas(self):
        sudoku=[
            ['4', '3', '5', '2', '6', '9', '7', '8', '1'], 
            ['6', '8', '2', '5', '7', '1', '4', '9', '3'],
            ['1', '9', '7', '8', '3', '4', '5', '6', '2'], 
            ['8', '2', '6', '1', '9', '5', '3', '4', '7'], 
            ['3', '7', '4', '6', '8', '2', '9', '1', '5'], 
            ['9', '5', '1', '7', '4', '3', '6', '2', '8'], 
            ['5', '1', '9', '3', '2', '6', '8', '7', '4'], 
            ['2', '4', '8', '9', '5', '7', '1', '3', '6'], 
            ['7', '6', '3', '4', '1', '8', '2', '5', '9']
        ]
        self.assertTrue(self.ordenTres.revisarColumnas(sudoku))
    def testRevisarCajas(self):
        sudoku=[
            ['4', '3', '5', '2', '6', '9', '7', '8', '1'], 
            ['6', '8', '2', '5', '7', '1', '4', '9', '3'],
            ['1', '9', '7', '8', '3', '4', '5', '6', '2'], 
            ['8', '2', '6', '1', '9', '5', '3', '4', '7'], 
            ['3', '7', '4', '6', '8', '2', '9', '1', '5'], 
            ['9', '5', '1', '7', '4', '3', '6', '2', '8'], 
            ['5', '1', '9', '3', '2', '6', '8', '7', '4'], 
            ['2', '4', '8', '9', '5', '7', '1', '3', '6'], 
            ['7', '6', '3', '4', '1', '8', '2', '5', '9']
        ]
        self.assertTrue(self.ordenTres.revisarCajas(sudoku))
    def testCaja(self):
        sudoku=[
            ['4', '3', '5', '2', '6', '9', '7', '8', '1'], 
            ['6', '8', '2', '5', '7', '1', '4', '9', '3'],
            ['1', '9', '7', '8', '3', '4', '5', '6', '2'], 
            ['8', '2', '6', '1', '9', '5', '3', '4', '7'], 
            ['3', '7', '4', '6', '8', '2', '9', '1', '5'], 
            ['9', '5', '1', '7', '4', '3', '6', '2', '8'], 
            ['5', '1', '9', '3', '2', '6', '8', '7', '4'], 
            ['2', '4', '8', '9', '5', '7', '1', '3', '6'], 
            ['7', '6', '3', '4', '1', '8', '2', '5', '9']
        ]
        esperado=['4', '3', '5', '6', '8', '2', '1', '9', '7']
        self.assertEqual(esperado,self.ordenTres.extraerCaja(sudoku,0))


    def testVerificarTodosMEtodos(self):
        cadena="435269781682571493197834562826195347374682915951743628519326874248957136763418259"
        self.assertTrue(self.ordenTres.revisar(cadena))


if __name__ == "__main__":
    unittest.main()
