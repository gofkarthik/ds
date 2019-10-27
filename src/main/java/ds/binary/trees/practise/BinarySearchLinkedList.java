package ds.binary.trees.practise;

public class BinarySearchLinkedList {

    BinaryNode root = null;

    BinaryNode insert(BinaryNode binaryNode, int value) {
        if (binaryNode == null) {
            binaryNode = new BinaryNode(value);
            return binaryNode;
        } else if (value <= binaryNode.value) {
            binaryNode.left = insert(binaryNode.left, value);
            return binaryNode;
        } else {
            binaryNode.right = insert(binaryNode.right, value);
            return binaryNode;
        }
    }

    BinaryNode search(BinaryNode binaryNode,int value){
        if(binaryNode == null){
            return null;
        }else if(binaryNode.value == value){
            return binaryNode;
        }else if(value <= binaryNode.value){
            return search(binaryNode.left,value);
        }else{
            return search(binaryNode.right,value);
        }
    }

}
