<?php



class ImageUploader
{

    var $servername = "localhost";
    var $dbname = "mas";
    var $email;
    var $password;

    public function __construct($email, $password)
    {
        $this->email = $email;
        $this->password = $password;
    }

    private function authUser($email, $password)
    {
        try {

            $conn = new mysqli($this->servername, "root", "", $this->dbname);



            $stmt = $conn->prepare("SELECT password_customer "
                . "FROM customers WHERE " .
                " email = ?");

            $stmt->bind_param("s", $email);
            $result = $stmt->execute();

            if ($result) {
                $result = $stmt->get_result();

                if ($result->num_rows == 1) {

                    $row = $result->fetch_assoc();


                    if ($row['password_customer'] == $password) {

                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (Exception $err) {
            die($err);
        }
        die("FAILED");
    }

    private function authProvider($email, $password)
    {

        try {

            $conn = new mysqli($this->servername, "root", "", $this->dbname);



            $stmt = $conn->prepare("SELECT password_customer "
                . "FROM providers INNER JOIN customers WHERE provider_email = email AND" .
                " provider_email = ?");

            $stmt->bind_param("s", $email);
            $result = $stmt->execute();
            $conn->close();
            if ($result) {
                $result = $stmt->get_result();

                if ($result->num_rows == 1) {

                    $row = $result->fetch_assoc();


                    if ($row['password_customer'] == $password) {

                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (Exception $err) {
            die($err);
        }
        die("FAILED");
    }

    public function setProfilePhoto()
    {
        if (!$this->authUser($this->email, $this->password))
            return;


        $conn = new mysqli($this->servername, "root", "", $this->dbname);



        $imgid = uniqid("", false);
        $post_image = $_FILES['image']['name'];
        $end = strtok($post_image, ".");
        $end = strtok('.'); //to get the extension of the file
        $post_image_temp = $_FILES['image']['tmp_name'];
        $imgName = "$imgid.$end";
        move_uploaded_file($post_image_temp, "data/profile_image/$imgName");

        $stmt = $conn->prepare("UPDATE customers "
            . "SET profile_photo=? " .
            "WHERE email = ?");

        $stmt->bind_param("ss", $imgName, $this->email);
        $stmt->execute();
        $conn->close();
    }

    public function addImageSlide()
    {
    }

    public function setMainServiceImage()
    {
        if (!$this->authProvider($this->email, $this->password))
            return;


        $conn = new mysqli($this->servername, "root", "", $this->dbname);

        $imgid = uniqid("", false);
        $post_image = $_FILES['image']['name'];
        $end = strtok($post_image, ".");
        $end = strtok('.'); //to get the extension of the file
        $post_image_temp = $_FILES['image']['tmp_name'];
        $imgName = "$imgid.$end";
        move_uploaded_file($post_image_temp, "data/main_service_image/$imgName");

        $stmt = $conn->prepare("UPDATE customers "
            . "SET main_img=? " .
            "WHERE email = ?");

        $stmt->bind_param("ss", $imgName, $this->email);
        $stmt->execute();
        $conn->close();
    }
}
