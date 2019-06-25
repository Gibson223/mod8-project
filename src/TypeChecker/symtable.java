package TypeChecker;

import java.util.*;

public class symtable{
    public innertable root;
    public innertable currentscope;

    public symtable() {
//        this.root = new innertable();
//        this.currentscope = root;
    }
    public symtable(boolean str) {
        if (str) {
            this.root = new innertable();
        }else {
            this.root = null;
        }
        this.currentscope = root;
    }

    public void openScope() {
        if (this.root == null) {
            this.root = new innertable();
            this.currentscope = root;
        } else {
            innertable child = new innertable(currentscope);
            this.currentscope = child;
        }
    }

    public void closeScope() throws RuntimeException{
        if (this.currentscope.parent == null) {
            throw new RuntimeException("tried to close global scope");
        }
        this.currentscope = this.currentscope.parent;
    }

    public List<int> gettype(String id) {
        innertable curr = currentscope;
        while (curr != root) {
            if (curr.contains(id)) {
                return curr.list.get(id);
            }
            curr = curr.parent;
        }
        if (this.root.contains(id)) {
            return this.root.list.get(id);
        }
        return SHOULD BE REPLACED BY THE ERROR TYPE; // TODO should be replaced by valid error type or if
    }

    public boolean add(String id, List<int> type) {
        return this.currentscope.add(id, type);
    }

    public boolean contains(String id) {
        innertable curr = currentscope;
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

    class innertable{
        public HashMap<String, List<int>> list = new HashMap<>();
        public innertable parent;
        public innertable(innertable parent) {
            this.parent = parent;
        }
        public innertable(){
            this.parent = null;
        }
        public boolean add(String id, List<int> type) {
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
