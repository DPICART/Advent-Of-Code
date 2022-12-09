package fr.daart.ex08;

public class Tree {
    int height;
    private final Tree leftTree;
    private final Tree topTree;
    private Tree rightTree;
    private Tree bottomTree;

    public Tree(int height, Tree leftTree, Tree topTree) {
        this.height = height;
        this.topTree = topTree;
        this.leftTree = leftTree;
    }


    @Override
    public String toString() {
        return "Tree{" +
                "height=" + height +
                "canBeSeen=" + canBeSeen() +
                '}';
    }

    public void setRightTree(Tree rightTree) {
        this.rightTree = rightTree;
    }

    public void setBottomTree(Tree bottomTree) {
        this.bottomTree = bottomTree;
    }

    public boolean canBeSeen() {
        return isABorderTree()
                || isHigherThanBottom(height)
                || isHigherThanTop(height)
                || isHigherThanRight(height)
                || isHigherThanLeft(height);

    }

    public int getScenicScore() {
        return getTopScore(this.height, 0) * getBottomScore(this.height, 0) * getRightScore(this.height, 0) * getLeftScore(this.height, 0);
    }

    public int getLeftScore(int maxHeight, int depth) {
        if (this.leftTree == null) {
            return depth;
        }
        if (this.leftTree.height < maxHeight) {
            return this.leftTree.getLeftScore(maxHeight, depth + 1);
        }
        return depth + 1;
    }

    public int getRightScore(int maxHeight, int depth) {
        if (this.rightTree == null) {
            return depth;
        }
        if (this.rightTree.height < maxHeight) {
            return this.rightTree.getRightScore(maxHeight, depth + 1);
        }
        return depth + 1;
    }

    public int getTopScore(int maxHeight, int depth) {
        if (this.topTree == null) {
            return depth;
        }
        if (this.topTree.height < maxHeight) {
            return this.topTree.getTopScore(maxHeight, depth + 1);
        }
        return depth + 1;
    }

    public int getBottomScore(int maxHeight, int depth) {
        if (this.bottomTree == null) {
            return depth;
        }
        if (this.bottomTree.height < maxHeight) {
            return this.bottomTree.getBottomScore(maxHeight, depth + 1);
        }
        return depth + 1;
    }

    private boolean isHigherThanBottom(int height) {
        return null == this.bottomTree ||
                (
                        this.bottomTree.height < height
                                && this.bottomTree.isHigherThanBottom(height)
                );
    }

    private boolean isHigherThanTop(int height) {
        return null == this.topTree ||
                (
                        this.topTree.height < height
                                && this.topTree.isHigherThanTop(height)
                );
    }

    private boolean isHigherThanRight(int height) {
        return null == this.rightTree ||
                (
                        this.rightTree.height < height
                                && this.rightTree.isHigherThanRight(height)
                );
    }

    private boolean isHigherThanLeft(int height) {
        return null == this.leftTree ||
                (
                        this.leftTree.height < height
                                && this.leftTree.isHigherThanLeft(height)
                );
    }

    private boolean isABorderTree() {
        return null == topTree
                || null == rightTree
                || null == leftTree
                || null == bottomTree;
    }
}
