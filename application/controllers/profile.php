<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Profile extends CI_Controller {
	
	public function index()
	{
		
		$this->load->view("dashboard_view");
	}

	public function customer($id)
	{
		$this->load->model("profile_model");
		$customer = $this->profile_model->getProfile($id);
		echo json_encode($customer);
	}
}

/* End of file profile.php */
/* Location: ./application/controllers/profile.php */