<?php
class Investments_model extends CI_Model {    

    function getInvestments($customerId)
    {
        $query = $this->db->get_where('transactions', array('customer_id' => $customerId));
        return $query->result();
    }

    function getInvestment($id = 1)
    {
        $query = $this->db->get_where('transactions', array('id' => $id));
        return $query->result();
    }

}
