<?php
class Goals_model extends CI_Model {    

    function getGoals($customerId)
    {
        $query = $this->db->get_where('goals', array('customer_id' => $customerId));
        return $query->result();
    }

    function getGoal($id = 1)
    {
        $query = $this->db->get_where('goals', array('id' => $id));
        return $query->result();
    }

    function addGoal($customerId,$typeId,$amount,$statusId,$startTime,$endTime)
    {
        $sql = "INSERT INTO goals (customer_id,type_id,amount,status_id,start_time,end_time) 
        VALUES ({$customerId},{$typeId},{$amount}{$statusId},{$startTime},{$endTime})";
        $query = $this->db->query($sql);
        return $query->result();
    }

}
