package domini.FabricaHidato;

import domini.TaulerHidato.Cella;

import java.util.ArrayList;

public class Graf {
    private ArrayList<Cella> vertexs;
    private ArrayList<Aresta> arestes;

    public Graf() {
        vertexs = new ArrayList<Cella>();
        arestes = new ArrayList<Aresta>();
    }

    public Graf(int x, int y) {
        vertexs = new ArrayList<Cella>();
        arestes = new ArrayList<Aresta>();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Cella aux = new Cella(i,j);
                aux.setNumero(0);
                vertexs.add(aux);
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Aresta aux;
                int index = j+i*y;
                if (j+1 < y) {  // aresta horitzontal
                    aux = new Aresta(vertexs.get(index), vertexs.get(index+1));
                    arestes.add(aux);
                }
                if (j+1 < y && i+1 < x) { // aresta 1a diagonal
                    aux = new Aresta(vertexs.get(index), vertexs.get(index+y+1));
                    arestes.add(aux);
                }
                if (i+1 < x) { // aresta vertical
                    aux = new Aresta(vertexs.get(index), vertexs.get(index+y));
                    arestes.add(aux);
                }
                if (i+1 < x && j-1 >= 0) { // aresta 2a diagonal
                    aux = new Aresta(vertexs.get(index), vertexs.get(index+y-1));
                    arestes.add(aux);
                }
            }
        }
    }
    
    public ArrayList<Cella> getAdjVer(Cella c) {
        ArrayList<Cella> ret = new ArrayList<Cella>();
        for (int i = 0; i < arestes.size(); i++) {
            if (arestes.get(i).contains(c)) {
                Aresta aux = arestes.get(i);
                if (aux.indexOf(c) == 0) ret.add(aux.get(1));
                else ret.add(aux.get(0));
            }
        }
        return ret;
    }

    // Reinicia els valors del graf a 0
    public void clear() {
        for (Cella c: vertexs) {
            c.setNumero(0);
        }
    }

    public ArrayList<Cella> getVertexs() {
        return this.vertexs;
    }

    public Cella getVertex(int i) {
        return vertexs.get(i);
    }

    public Cella getVertex(Cella c) {
        return vertexs.get(vertexs.indexOf(c));
    }

    public void setValor(int i, int val) {
        vertexs.get(i).setNumero(val);
    }
}
