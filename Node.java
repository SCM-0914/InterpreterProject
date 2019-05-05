abstract class Node<E>{//abstract because it serves little use instantialized
    E data;
    Node left;
    Node right;

    protected Node(E d){
        setData(d);
    }
    
    protected Node(){}

    protected Node(Node l,Node r){
        setLeft(l);
        setRight(r);
    }

    protected Node(E d,Node l,Node r){
        setLeft(l);
        setRight(r);
        setData(d);
    }

    protected void setLeft(Node l){left = l;}

    protected void setRight(Node r){right = r;}

    protected Node getLeft(){return left;}

    protected Node getRight(){return right;}

    protected E getData(){return data;}

    protected void setData(E d){data = d;}
    
    public String toString(){
        if(left == null && right == null){return data+"";}
        if(left == null){return data+" -> "+right;}
        if(right == null){return left+" <- "+data;}
        return left+" <- "+data+" -> "+right;
    }

    public static class ExpressionNode extends Node<String>{
        ExpressionNode(String val){
            super(val);
        }

        ExpressionNode(String op, ExpressionNode left, ExpressionNode right){
            super(op,left,right);
        }

        public void setLeft(Node l){super.setLeft(l);}

        public void setRight(Node r){super.setRight(r);}

        public Node getLeft(){return super.getLeft();}

        public Node getRight(){return super.getRight();}
        
        public String getData(){return super.getData();}
    }

    public static class LetStatement extends Node<String>{
        public LetStatement(StatementNode s, ExpressionNode e){
            super("=",s,e);
        }

        public LetStatement(){super();}

        void setStatement(StatementNode sn){super.setLeft(sn);}

        void setExpression(ExpressionNode en){super.setRight(en);}
        
        public String getData(){return super.getData();}
    }

    public static class StatementNode extends Node<String>{
        StatementNode(String name){
            super(name);
        }

        public String getName(){return super.getData();}
    }

}

