//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 

class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> result;
        stack<TreeNode*> nodeStack;
        //base case
        if (root == null) {
        	return result;
        }
        nodeStack.push(root) 
        while (!nodeStack.empty()) {
        	TreeNode * node = nodeStack.top();
        	result.push_back(node.val);
        	nodeStack.pop();
        	if (node->left) {
        		nodeStack.push(node->left);
        	}
        	if (node->right) {
        		nodeStack.push(node->right);
        	}
        }
        reverse(result.begin(),result.end());
        return result;
    }
};