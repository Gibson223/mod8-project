package TypeChecker;

import java.util.*;

public class SymbolTable {
    public InnerTable root;
    public InnerTable currentscope;

    public SymbolTable() {
//        this.root = new InnerTable();
//        this.currentscope = root;
    }
    public SymbolTable(boolean str) {
        if (str) {
            this.root = new InnerTable();
        }else {
            this.root = null;
        }
        this.currentscope = root;
    }

    public void openScope() {
        if (this.root == null) {
            this.root = new InnerTable();
            this.currentscope = root;
        } else {
            InnerTable child = new InnerTable(currentscope);
            this.currentscope = child;
        }
    }

    public void closeScope() throws RuntimeException{
        if (this.currentscope.parent == null) {
            throw new RuntimeException("tried to close global scope");
        }
        this.currentscope = this.currentscope.parent;
    }

    public ArrayList<Integer> getType(String id) {
        InnerTable curr = currentscope;
        while (curr != root) {
            if (curr.contains(id)) {
                return curr.list.get(id);
            }
            curr = curr.parent;
        }
        if (this.root.contains(id)) {
            return this.root.list.get(id);
        }
        return null; // TODO should be replaced by valid error type or if
    }

    public boolean add(String id, ArrayList<Integer> type) {
        return this.currentscope.add(id, type);
    }

    public boolean contains(String id) {
        InnerTable curr = currentscope;
        while (curr != root) {
            if (curr.contains(id)) {
                return true;
            }
            curr = curr.parent;
        }
        return this.root.contains(id);
    }

    public boolean inCurrentScope(String id) {
        return this.currentscope.contains(id);
    }

    class InnerTable{
        public HashMap<String, ArrayList<Integer>> list = new HashMap<>();
        public InnerTable parent;
        public InnerTable(InnerTable parent) {
            this.parent = parent;
        }
        public InnerTable(){
            this.parent = null;
        }
        public boolean add(String id, ArrayList<Integer> type) {
            if (this.list.containsKey(id)) {
                return false;
            }
            this.list.put(id, type);
            return true;
        }
        public boolean contains(String id) {
            return this.list.containsKey(id);
        }
    }
}
