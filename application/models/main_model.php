<?php
class Main_model extends CI_Model {    

    function getDashboardData($customerId)
    {
        //$query = $this->db->get('transaction_type', 10);
        //return $query->result();
        $profile = $this->getCustomer($customerId);
        $data['profile'] = $profile[0];
    	$data['goals'] = $this->getGoals($customerId);
    	$data['investments'] = $this->getInvestments($customerId);
    	$data['contracts'] = $this->getContracts($customerId);
    	return $data;
    }

    function getCustomers()
    {
        $query = $this->db->get('customers', 10);
        return $query->result();
    	$sql = "SELECT c.id, c.amount FROM customers as c
    	LEFT JOIN goals as g ON g.customer_id = {$customerId}
    	LEFT JOIN transactions as t ON t.customer_id = {$customerId}
    	WHERE c.id = {$customerId}";
    	$query = $this->db->query($sql);
    	$result = $query->result();


    	//return $result;

    	$data['profile'] = $this->getCustomer($customerId);
    	$data['goals'] = $this->getGoals($customerId);
    	$data['investments'] = $this->getInvestments($customerId);
    	$data['contracts'] = $this->getContracts($customerId);
        return $data;
    }

    function getGoals($customerId)
    {
        $sql = "SELECT g.id,gt.type,gs.status,g.amount FROM goals as g
        LEFT JOIN goal_type as gt ON gt.id = g.type_id
        LEFT JOIN goal_status as gs ON gs.id = g.status_id
        WHERE g.customer_id = {$customerId}
        ";
        $query = $this->db->query($sql);
        return $query->result();
    }

    function getInvestments($customerId)
    {
    	$sql = "SELECT tt.type,t.amount FROM transactions as t
        LEFT JOIN transaction_type as tt ON tt.id = t.type_id
        WHERE t.customer_id = {$customerId}
        ";
        $query = $this->db->query($sql);
        return $query->result();
    }

    function getContracts($customerId)
    {
        $query = $this->db->get_where('contracts', array('customer_id' => $customerId));
        return $query->result();
    }

    function getCustomer($id = 1)
    {
        $sql = "SELECT name,amount FROM customers WHERE id = {$id}";
        $query = $this->db->query($sql);
        return $query->result();
    }

}
