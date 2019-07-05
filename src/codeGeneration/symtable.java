package codeGeneration;

import java.text.ParseException;
import java.util.*;

public class symtable{
    public innertable root;
    public innertable currentscope;
    private int topbeforenewscope; // requires a rename

    public symtable(boolean str) {
        if (str) {
            this.root = new innertable();
        }else {
            this.root = null;
        }
        this.currentscope = root;
    }

    public int sprilID(String id) {
        innertable curr = currentscope;
        while (curr != root) {
            if (curr.contains(id)) {
                return curr.sprockel_ID;
            }
            curr = curr.parent;
        }
        if (this.root.contains(id)) {
            return this.root.sprockel_ID;
        }
        throw new RuntimeException("no sprockellID for variable name");
    }


    public void openScope(int sprillID) {
        if (this.root == null) {
            this.root = new innertable();
            this.currentscope = root;
        } else {
            innertable child = new innertable(currentscope, sprillID);
            this.currentscope = child;
        }
    }

    public void closeScope() throws RuntimeException{
        if (this.currentscope.parent == null) {
            throw new RuntimeException("tried to close global scope");
        }
        this.currentscope = this.currentscope.parent;
    }

    public int getHeapLoc(String id) {
        innertable curr = currentscope;
        while (curr != root) {
            if (curr.contains(id)) {
                return curr.heaplocation.get(id);
            }
            curr = curr.parent;
        }
        if (this.root.contains(id)) {
            return this.root.heaplocation.get(id);
        }
        throw new RuntimeException("tried to fetch undeclared var (in getHeapLoc)");
    }


    public List<Integer> getType(String id) {
        innertable curr = currentscope;
        while (curr != root) {
            if (curr.contains(id)) {
                return curr.type.get(id);
            }
            curr = curr.parent;
        }
        if (this.root.contains(id)) {
            return this.root.type.get(id);
        }
        throw new RuntimeException("tried to fetch undeclared var (in gettype)"); // TODO should be replaced by valid error type or if
    }

    public void add(String id, List<Integer> type, int heaplocation) {
        this.currentscope.add(id, type, heaplocation );
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
        private HashMap<String, List<Integer>> type = new HashMap<>();
        public HashMap<String, Integer> heaplocation = new HashMap<>();
        private innertable parent;
        private int sprockel_ID;
        public innertable(innertable parent, int sprilid) {
            this.parent = parent; sprockel_ID = sprilid;
        }
        public innertable(){
            this.parent = null; sprockel_ID = 0;
        }

        // for getting the
        public int getHeapLoc(String id) {
            if (!this.type.containsKey(id)) {
                throw new RuntimeException("tried to get heaplocation for undeclared var");
            }
            return this.heaplocation.get(id);
        }

        public int parentId() {
            return this.parent.sprockel_ID;
        }

        // todo figure out if this one is actually ever used
        // for assignment of already typedeclared var
        public void addLoc(String id, int heappos) {
            if (!this.type.containsKey(id)) {
                throw new RuntimeException("tried assignment but type not yet declared");
            }
            this.heaplocation.put(id, heappos);
        }

        // for declaration without assignment
        public void addType(String id, List<Integer> type) {
            if (this.type.containsKey(id)) {
                System.out.println("type declaration invalid, variable already declared in current scope");
                throw new RuntimeException("type redeclaration not allowed, already in scope");
            }
            this.type.put(id, type);
        }
        // for declaration with assignment
        public void add(String id, List<Integer> type, int value) {
            if (this.type.containsKey(id)) {
                System.out.println("tried to declare (and assign)variable that is already declared in current scope");
                throw new RuntimeException("redeclaration not allowed in 1 scope");
            }
            this.type.put(id, type);
            this.heaplocation.put(id, value);
        }
        public boolean contains(String id) {
            return this.type.containsKey(id);
        }
    }
}
