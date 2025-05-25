package ds_project;



public class Trees {

    NODETrees root;

    public Trees() {
        root = null;
    }

   /* public NODETrees findNode(String val) {
        NODETrees temp = root;
        int z = Integer.parseInt(val);
        while (temp != null && temp.data != val) {
            if (z < temp.x) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }*/

    /*boolean find(String val) {
        return findNode(val) != null;
    }*/

    public boolean isParentWithOneChild(NODETrees node) {
        return (node.left == null && node.right != null) || (node.right == null && node.left != null);
    }

   /* public NODETrees findParent(String val) {
        NODETrees cur = root;
        NODETrees Parent = null;
        int si =  Integer.parseInt(val);
        while (cur != null && cur.data != val) {
            Parent = cur;
            if (si < cur.x) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }

        }
        return Parent;
    }*/

    public void insert(String data) {
        data = data.replaceAll(" ", "");
        if (isOperator(data.charAt(0))) {
            data = prefix_To_infix(data);
        } else if (!isOperator(data.charAt(1))) {
            data = postfix_To_infix(data);
        }
        if (root == null) {
            root = new NODETrees(data.charAt(0) + "");
        }
        NODETrees curr = root;
        for (int i = 1; i < data.length(); i++) {
            if (isOperator(data.charAt(i)) && !isOperator(root.data.charAt(0))) {
                NODETrees q = new NODETrees(data.charAt(i) + "");
                q.left = root;
                root = q;
                curr = q;
            } else if (isOperator(data.charAt(i))) {
                NODETrees q = new NODETrees(data.charAt(i) + "");
                if (operatorType(root.data.charAt(0)) == 3 
                        || operatorType(root.data.charAt(0)) == 4) {
                    q.left = root;
                    root = q;
                    curr = q;
                } else if (operatorType(root.data.charAt(0)) == 2 
                        && (operatorType(data.charAt(i)) == 1
                        || operatorType(data.charAt(i)) == 2)) {
                    q.left = root;
                    root = q;
                    curr = q;
                }  else {
                    q.left = root.right;
                    root.right = q;
                    curr = q;
                }
            } else {
                curr.right = new NODETrees(data.charAt(i) + "");

            }

        }

    }
    
    public String postfix_To_infix(String post) {
        String in = "";
        String op = "";
        boolean isop = false;
        for (int i = 0; i < post.length(); i++) {
            if (isOperator(post.charAt(i))) {
                op = op + post.charAt(i);
            }
        }
        for (int j = 0, k = 0; j < post.length(); j++) {
            if (!isOperator(post.charAt(j))) {
                if (!isop) {
                    in = in + post.charAt(j);
                    isop = true;
                } else {
                    in = in + op.charAt(k);
                    k++;
                    isop = false;
                    j--;
                }
            }
        }
        return in;
    }
   
    public String prefix_To_infix(String pre) {
        String in = "";
        String num = "";
        boolean isnum = true;
        for (int i = 0; i < pre.length(); i++) {
            if (!isOperator(pre.charAt(i))) {
                num = num + pre.charAt(i);
            }
        }
        for (int j = 0, k = 0; j < pre.length(); j++) {
            if (isOperator(pre.charAt(j))) {
                if (isnum) {
                    in = in + num.charAt(k);
                    j--;
                    k++;
                    isnum = false;
                } else {
                    in = in + pre.charAt(j);
                    isnum = true;
                }
            }
            if (j + 1 == pre.length()) {
                in = in + num.charAt(k);
            }
        }
        return in;
    }
    
    

    public NODETrees getRightMostNode(NODETrees node) {
        NODETrees rmn = node;
        while (rmn.right != null) {
            rmn = rmn.right;
        }
        return rmn;

    }

    public boolean isLeaf(NODETrees node) {
        return node.left == null && node.right == null;
    }

   /* public String Remove(String val) {
        String v;
        NODETrees del = findNode(val);
        NODETrees Parent = findParent(val);

        if (del == null) {
            System.out.println("Node not found ");
            System.exit(1);
        }
        if (isLeaf(del)) {
            if (del == root) {
                root = null;
            } else {
                if (Parent.left == del) {
                    Parent.left = null;
                } else {
                    Parent.right = null;
                }
            }
            v = del.data;

        } else if (isParentWithOneChild(del)) {
            if (Parent.right == del) {
                if (del.right != null) {
                    Parent.right = del.right;
                } else {
                    Parent.right = del.left;
                }
            } else {
                if (del.right != null) {
                    Parent.left = del.right;
                } else {
                    Parent.left = del.left;
                }
            }

            v = del.data;
        } else {
            NODETrees highstLeftNode = getRightMostNode(del.left);
            v = Remove(highstLeftNode.data);
            del.data = v;
        }

        return val;

    }*/
    
    
     

         
       
            
            public int operatorType(char op) {
        switch (op) {
            case '+':
                return 1;
            case '-':
                return 2;
            case '*':
                return 3;
            default:
                return 4;
        }
    }

    public boolean isOperator(char ch) {
        return (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/');
    }

    public boolean isOperand(char c) {
        return (c >= '0' && c <= '9');
    }
    
    public int eva_helper(NODETrees u) {
        if (isOperator(u.data.charAt(0))) {
            switch (operatorType(u.data.charAt(0))) {
                case 1:
                    return eva_helper(u.left) + eva_helper(u.right);
                case 2:
                    return eva_helper(u.left) - eva_helper(u.right);
                case 3:
                    return eva_helper(u.left) * eva_helper(u.right);
                case 4:
                    return eva_helper(u.left) / eva_helper(u.right);
            }
        }
        return Integer.parseInt(u.data.charAt(0) + "");

    }
    
       public int evaluate() {
        return eva_helper(root);
    }
    
    
    
   
}
